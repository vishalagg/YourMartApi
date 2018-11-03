package com.nagarro.yourmartapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.dto.ProductResponse;
import com.nagarro.yourmartapi.entity.Product;
import com.nagarro.yourmartapi.enums.ProductStatus;
import com.nagarro.yourmartapi.exceptions.BadRequest;
import com.nagarro.yourmartapi.exceptions.ServerSideException;
import com.nagarro.yourmartapi.exceptions.UnAuthorizedException;
import com.nagarro.yourmartapi.exceptions.UnexpectedError;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;
import com.nagarro.yourmartapi.util.Utility;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@GetMapping("/product")
	public List<ProductResponse> getAllProduct(@RequestParam(value="offset",required=false,defaultValue="0") int offset,
									   @RequestParam(value="limit",required=false,defaultValue="10") int limit,
									   @RequestParam(value="sortBy",required=false) String sortBy,
									   @RequestParam(value="searchKey",required=false) String searchKey,
									   @RequestParam(value="searchQuery",required=false) String searchQuery,
									   @RequestParam(value="status",required=false) String status,
									   @RequestParam(value="category",required=false) String category,
									   @RequestHeader(value="authentication") String token) {
		try {
			int productStatus = -1;
			if(status!=null) {
				productStatus = ProductStatus.valueOf(status).ordinal();
			}
			List<Product> products = productRepository.getAllProduct(offset,limit,sortBy,searchKey,searchQuery,productStatus,category,token);
			List<ProductResponse> productListResponse =  Utility.convertModelList(products, ProductResponse.class);
			return productListResponse;			
		}catch(Exception e) {
			throw new UnexpectedError();
		}
	}
	
	@PostMapping(path = "/product")
	public void addProduct(@RequestBody Product product,
						   @RequestHeader(value="authentication") String token) {
		try {
			if(sellerRepository.isAuthenticatedByToken(product.getSeller().getId(),token)) {
				try {
					product.setStatus(ProductStatus.NEW.ordinal()+1);
					productRepository.save(product);				
				}catch(Exception e) {
					throw new BadRequest();
				}
			}
		}catch(Exception e) {
			throw new UnAuthorizedException();
		}
	}
	
	@GetMapping(path="/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		try {
			return productRepository.getProduct(id);			
		}catch(Exception e) {
			throw new UnexpectedError();
		}
	}
	
	@PutMapping(path="/product/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product,
							     @RequestHeader(value="authentication") String token) {
		Product updatedProduct = null;
		try {
			if(sellerRepository.isAuthenticatedByToken(product.getSeller().getId(),token)) {
				try {
					updatedProduct = productRepository.updateProduct(product);			
				}catch(Exception e) {
					throw new BadRequest();	
				}				
			}	
		}catch(Exception e) {
			throw new UnAuthorizedException();
		}
		return updatedProduct;
	}
	
	@DeleteMapping(path="/product/{id}")
	public void deleteProduct(@PathVariable("id") int id,
							  @RequestHeader(value="authentication") String token) {
		int sellerId = productRepository.getProduct(id).getSeller().getId();
		try {
			if(sellerRepository.isAuthenticatedByToken(sellerId,token)) {
				try {
					productRepository.deleteProduct(id);			
				}catch(Exception e) {
					throw new ServerSideException();
				}	
			}
		}catch(Exception e) {
			throw new UnAuthorizedException();
		}
	}
}
