package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	private Long parentId;
	
	/*列表*/
	public String list(){		
//		List<Department> departmentList = departmentService.findAll();
		List<Department> departmentList = null;		
		
		if(parentId == null){
			departmentList = departmentService.findTopList();			
		}else{
			departmentList = departmentService.findChildren(parentId);	
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";		
	}
	
	/*删除*/
	public String delete(){
		departmentService.delete(model.getId());
		return "toList";		
	}
	
	/*添加页面*/
	public String addUI(){
		//准备数据
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);		
		return "saveUI";		
	}
	
	/*添加*/
	public String add(){
		//把数据封装到对象model中进行保存
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";		
	}
	
	/*修改页面*/
	public String editUI(){
		//准备数据
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);		
		
		//准备回显的数据
		Department department = departmentService.getById(model.getId());				
		ActionContext.getContext().getValueStack().push(department);
		if(department.getParent()!=null){
			parentId = department.getParent().getId();			
		}
		return "saveUI";		
	}
	
	/*修改*/
	public String edit(){
		//1.取出对象
		Department department = departmentService.getById(model.getId());
		//2.设置需要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		//设置所属的上级部门
		department.setParent(departmentService.getById(parentId));
		//3.更新到数据库库中
		departmentService.update(department);
		return "toList";		
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	
}
