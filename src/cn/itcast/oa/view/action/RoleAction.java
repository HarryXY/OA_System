package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	/*列表*/
	public String list(){
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";		
	}
	
	//删除
	public String delete(){
		roleService.delete(model.getId());
		return "toList";
	}
	
	//添加页面
	public String addUI(){
		return "saveUI";
	}
	
	//添加
	public String add(){
		
		Role role = new Role();
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.add(role);
		return "toList";
	}
	
	//修改页面
	public String editUI(){
		Role role = roleService.getById(model.getId());
//		this.name = role.getName();
//		this.description = role.getDescription();
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	//修改
	public String edit(){
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		return "toList";
	}

		
	

}











