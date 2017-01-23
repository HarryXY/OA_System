package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {
/**
 * 遍历部门树，把所有部门遍历出来添加到集合中返回，并且名称都已经改变
 * @param topList
 * @return
 */
	public static List<Department> getAllDepartments(List<Department> topList) {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<Department>();
		walkDepartmentTreeList(topList, "┣", list);
		return list;
	}

	private static void walkDepartmentTreeList(Collection<Department> topList, String prefix, List<Department> list) {
		// TODO Auto-generated method stub	
		for(Department top : topList){
			Department copy = new Department();
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);
			Collection<Department> childrenList = top.getChildren();
			if(childrenList != null){
				walkDepartmentTreeList(childrenList, "　" + prefix, list);
			}
		}
	}

}
