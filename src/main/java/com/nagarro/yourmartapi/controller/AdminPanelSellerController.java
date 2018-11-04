package com.nagarro.yourmartapi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.enums.SellerStatus;
import com.nagarro.yourmartapi.repository.SellerRepository;

@Controller
public class AdminPanelSellerController {

	@Autowired
	private SellerRepository sellerRepository;
	
	@RequestMapping(value="/admin/seller",method = RequestMethod.GET)
	public String getAllSeller(Model model,HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="offset",required=false,defaultValue="0") int offset,
								@RequestParam(value="limit",required=false,defaultValue="10") int limit,
								@RequestParam(value="status",required = false) String status, 
								@RequestParam(value="searchQuery",required = false) String searchQuery,
								@RequestParam(value="searchKey",required = false) String searchKey,
								@RequestParam(value="sortBy",defaultValue="statusId") String sortBy){
		
		HttpSession session = request.getSession(false);
		model.addAttribute("searchQuery", searchQuery);
		if(searchKey!=null) {
			String companySelected = searchKey.equals("COMPANY_NAME") ? "selected" : " "; 
			model.addAttribute("companySelected", companySelected);
			String ownerSelected = searchKey.equals("OWNER_NAME") ? "selected" : " "; 
			model.addAttribute("ownerSelected", ownerSelected);
			String phoneSelected = searchKey.equals("PHONE") ? "selected" : " "; 
			model.addAttribute("phoneSelected", phoneSelected);
		}
		if(sortBy!=null) {
			String idChecked = sortBy.equals("id") ? "checked" : " "; 
			model.addAttribute("idChecked", idChecked);
			String createdAtChecked = sortBy.equals("createdAt") ? "checked" : " "; 
			model.addAttribute("createdAtChecked", createdAtChecked);
			
		}
		if(status!=null) {
			String needApprovalChecked = status.equals("NEED_APPROVAL") ? "checked" : " "; 
			model.addAttribute("needApprovalChecked", needApprovalChecked);
			String approvedChecked = status.equals("APPROVED") ? "checked" : " "; 
			model.addAttribute("approvedChecked", approvedChecked);
			String rejectedChecked = status.equals("REJECTED") ? "checked" : " "; 
			model.addAttribute("rejectedChecked", rejectedChecked);
		}
		if(session!=null && session.getAttribute("admin")!=null) {
			ArrayList<Seller> sellers = new ArrayList<>();
			model.addAttribute("offset", offset);
			sellers = (ArrayList<Seller>) sellerRepository.getAllSeller(offset, limit, sortBy,status,searchKey,searchQuery);
			model.addAttribute("sellers", sellers);
			Long totalSeller = sellerRepository.totalSeller();
			int paginationSize = (int) (totalSeller/limit);
			model.addAttribute("paginationSize", paginationSize);
			return "seller";
		}
		return "redirect:/admin/login";
	}
	
	@RequestMapping(value="/admin/seller",method = RequestMethod.POST)
	public String homePage(HttpServletRequest request, HttpServletResponse response) {
		String[] ids = request.getParameterValues("cbox");
		if(ids!=null) {
			for(String value : ids) {
				// 1=>NEED_APPROVAL 2=>APPROVED 3=>REJECTED
				sellerRepository.setStatus(Integer.parseInt(value),(SellerStatus.APPROVED.ordinal()+1)+"");
			}			
		}
		return "redirect:/admin/seller";
	}
	
	@RequestMapping(value="/admin/seller/{sellerId}", method = RequestMethod.GET)
	public String sellerDetailsPage(HttpServletRequest request, HttpServletResponse response,
									@PathVariable("sellerId") int id, ModelMap model,
									@RequestParam(value="status",required = false) String status) {
		if(status!=null) {
			System.out.println(status + "  ssds" + id);
			sellerRepository.setStatus(id, status);
		}
		Seller seller = sellerRepository.getSeller(id);
		model.addAttribute("seller", seller);
		return "sellerDetails";
	}
}
