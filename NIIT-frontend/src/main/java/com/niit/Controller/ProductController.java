package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;



@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    SupplierDAO supplierDAO;
	public ProductController(){
	System.out.println("ProductController Bean is Created");
}
	@RequestMapping(value="/all/getsupplierform")
	public ModelAndView getSupplierForm(Model model)
	{
		model.addAttribute("suppliers",supplierDAO.findAllSuppliers());
		return new ModelAndView("Supplier");
		
	}

	
@RequestMapping(value="/all/getcategoryform")
public ModelAndView getCategoryForm(Model model)
{
	model.addAttribute("categories",categoryDAO.findAllCategorys());
	return new ModelAndView("Category");
	
}


@RequestMapping(value="/all/getallproducts")
public String getAllProducts(Model model){
	List<Product> products=productDAO.findAllProduct();
	//Attribute name is the Key - productList
	//value - List<Product> products is the data
	model.addAttribute("productsList",products);
	model.addAttribute("categories",productDAO.findAllCategories());
	//                 
	return "listofproducts";//logical view name
	//in listofproducts.jsp,access the model attribute "productsList"
	
}
@ModelAttribute("supplier")
public Supplier getSupplier()
{
	return new Supplier();
}

@RequestMapping(value="/admin/addsupplier")
public ModelAndView addSupplier(@ModelAttribute("Supplier")Supplier supplier)

{
	
supplierDAO.addSupplier(supplier);	
return new ModelAndView("Supplier");
}

@ModelAttribute("Category")
public Category getCategory()
{
	return new Category();
}
@RequestMapping(value="/admin/addcategory")
public ModelAndView addCategory(@ModelAttribute("Category")Category category)
{
	
categoryDAO.addCategory(category);	
return new ModelAndView("listofcategory");
}
@RequestMapping(value="/admin/addproduct")
public String addProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result,Model model ,HttpServletRequest request,@RequestParam("image") MultipartFile filedet )
{
	if(result.hasErrors()){//if it is true, result has errors
		model.addAttribute("categories",productDAO.findAllCategories());
		return "productform";
	}
	
	productDAO.addProduct(product);
	String path="F:\\eclipse-workspace1\\frontend\\src\\main\\webapp\\resources\\images\\";	
	String fileinfo=path+product.getProductid()+".jpg";
	File f=new File(fileinfo);
	
	if(!filedet.isEmpty())
	{
		try
		{
			byte buff[]=filedet.getBytes();
			FileOutputStream fos=new FileOutputStream(f);
			BufferedOutputStream bs = new BufferedOutputStream(fos);
			bs.write(buff);
		}
		catch(Exception e)
		{
			System.out.println("Exception arised");
		}
		
	System.out.println(request.getServletContext().getRealPath("/"));

Path path1=Paths.get(request.getServletContext().getRealPath("/")+"/resources/images/"+product.getProductid()+".jpg");
//transfer the image to the file
		

	return "redirect:/all/getallproducts";
		
}
	return fileinfo;
}

@RequestMapping(value="/admin/deleteproduct/{ProductId}")
public String deleteProduct(@PathVariable int ProductId,Model model,HttpServletRequest request){
	productDAO.deleteProduct(ProductId);
	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/resources/images/"+ProductId+".jpg");
	if(Files.exists(path)){
		try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return "redirect:/all/getallproducts";
}
@RequestMapping(value="/all/getproduct/{ProductId}")
public String getProduct(@PathVariable int ProductId,Model model){
	Product product=productDAO.findProductById(ProductId);
	model.addAttribute("productObj",product);
	return "viewproducts";
}
@RequestMapping(value="/admin/getproductform")
public String getproductform(Model model){
	Product p=new Product();
	model.addAttribute("product",p);
	model.addAttribute("categories",productDAO.findAllCategories());
	//In productform, access  the values of all the properties of product p
	//in the form, p.getId(),p.getProductname(),p.getPrice(),p.getQuantity(),p.getProductdesc()
	return "productform";
}
@RequestMapping(value="/admin/getupdateform/{ProductId}")
public String getUpdateProductForm(@PathVariable int ProductId,Model model){
	//how to get the product?
	Product product=productDAO.findProductById(ProductId);
	model.addAttribute("product",product);
	model.addAttribute("categories",productDAO.findAllCategories());
	return "updateproductform";
}
@RequestMapping(value="/admin/updateproduct")
public String updateProduct(@ModelAttribute Product product,BindingResult result,Model model,HttpServletRequest request,@RequestParam("image") MultipartFile filedet){//product will have updated values
	   if(result.hasErrors()){
		   model.addAttribute("categories",productDAO.findAllCategories());
		   return "updateproductform";
	   }

	//product will have updated values
	productDAO.updateProduct(product);
	String path="F:\\eclipse-workspace1\\frontend\\src\\main\\webapp\\resources\\images\\";
	MultipartFile img=product.getImage();
	System.out.println(request.getServletContext().getRealPath("/"));
	//Defining a path
	Path path1=Paths.get(request.getServletContext().getRealPath("/")+"/resources/images/"+product.getProductid()+".jpg");
	//transfer the image to the file
	
	return "redirect:/all/getallproducts";	
	}
@RequestMapping(value="/all/searchByCategory")
public String searchByCategory(@RequestParam String searchCondition ,Model model){
	if(searchCondition.equals("All"))
		model.addAttribute("searchCondition","");
	else
	model.addAttribute("searchCondition",searchCondition);
	model.addAttribute("productsList",productDAO.findAllProduct());
	return "listofproducts";
}
}


