package addHandler;

import dao.addDao;
import dao.editDao;
import entity.Product;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class productMB {

    Product product = new Product();
    Product newProduct = new Product();
    editDao editDao = new editDao();
    
    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String addProduct() {
        if (product.getProName().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Product Name Required", ""));
        } 
        else if (product.getProDetails().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Product Details Required", ""));
        } 
        else if (product.getPrice() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Product Price Required", ""));
        } 
        else if (product.getQty() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Product Quantity Required", ""));
        } 
        else {
            product.setProName(product.getProName());
            product.setProDetails(product.getProDetails());
            product.setPrice(product.getPrice());
            product.setQty(product.getQty());
            boolean status = new addDao().addProduct(product);
            if (status) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Product Saved", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error to Save Product", ""));
            }
        }
        return null;
    }
    public void updateProduct(Product newProduct){
        String Name = newProduct.getProName();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Name", Name);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);          
        editDao.updatePro(newProduct);  
        System.out.println("User Info successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User updated successfully .");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        newProduct = new Product();
    }
    
    public void deleteProduct(Product product)  
    {     
        editDao.deletePro(product);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Product deleted successfully");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    } 
    public void changePro(Product product){
        this.newProduct = product;
    }

    public String proAdd() {
        return "addProduct?faces-redirect=true";
    }

    public String proDetails() {
        return "productDetails?faces-redirect=true";
    }
    public String proUpdate(){
        return "updateProduct?faces-redirect=true";
    }
}
