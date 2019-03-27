package com.server.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONObject;

import com.server.entity.MenuEntity;

public class MethodsUtils {
	
	@SuppressWarnings("unchecked")
	public String mountedMenuJson(List<MenuEntity> listEntityElement) throws Exception {
		
		Collection<JSONObject> collectionRoot = new ArrayList<JSONObject>();
		if (listEntityElement != null) {
			for (MenuEntity root : listEntityElement) {
				JSONObject jsonRoot = new JSONObject();

				if(root.getMenuPai() == null) {
					jsonRoot.put("root-menu", root.getDescricao());
					
					Collection<JSONObject> collectionChildren = new ArrayList<JSONObject>();
					for (MenuEntity children : listEntityElement) {
						JSONObject jsonChildren = new JSONObject();
						
						if(root.getMenuItem().equals(children.getMenuPai())) {
							jsonChildren.put("root-menu", children.getDescricao());
							collectionChildren.add(jsonChildren);
						}
					}

					if(!collectionChildren.isEmpty()) {
						jsonRoot.put("sub-menu", collectionChildren);
					}

					collectionRoot.add(jsonRoot);
				}
				
			}
		}
		
		return collectionRoot.toString();
	}

}
