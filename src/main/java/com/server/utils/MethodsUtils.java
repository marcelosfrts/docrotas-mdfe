package com.server.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.server.entity.AddressEntity;
import com.server.entity.CompanyEntity;
import com.server.entity.MenuEntity;
import com.server.entity.NeighborhoodEntity;

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
	
	@SuppressWarnings("unchecked")
	public String mountedCompanySelectedJson(List<CompanyEntity> listEntityElement) throws Exception {
		
		Collection<JSONObject> collectionObject = new ArrayList<JSONObject>();
		if (listEntityElement != null) {			
			for (CompanyEntity company : listEntityElement) {
				JSONObject jsonRoot = new JSONObject();
				jsonRoot.put("value", company.getId());
				jsonRoot.put("text", company.getId() + "-" + company.getReason());
				
				collectionObject.add(jsonRoot);
			}
		}
		return collectionObject.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String mountedNeighborhoodSelectedJson(List<NeighborhoodEntity> listEntityElement) throws Exception {
		
		Collection<JSONObject> collectionObject = new ArrayList<JSONObject>();
		if (listEntityElement != null) {			
			for (NeighborhoodEntity entity : listEntityElement) {
				JSONObject jsonRoot = new JSONObject();
				jsonRoot.put("value", entity.getId());
				jsonRoot.put("text", entity.getNome());
				
				collectionObject.add(jsonRoot);
			}
		}
		return collectionObject.toString();
	}
	
	public boolean isValidListDocuments(String key, List<String> listDocuments) throws Exception {
		if (key != null && key.length() == 44) {
			for (String document : listDocuments) {
				if (!document.substring(20, 22).equals(key.substring(20, 22))) {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}

}