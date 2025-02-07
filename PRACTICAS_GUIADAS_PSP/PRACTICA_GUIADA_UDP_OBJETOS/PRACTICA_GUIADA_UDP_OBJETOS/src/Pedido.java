
import java.io.Serializable;

public class Pedido implements Serializable{

	 private String burger;
	
	 private String company;
	
	 private String refresco;
	
	 public Pedido(String burger, String company, String refresco) {
	
	 this.burger = burger;
	 
	 this.company = company;
	
	 this.refresco = refresco;

 }


	 public String getburger() {
	
	 return burger;
	
	 }


	 public String getcompany() {
	
	 return company;
	
	 }


	 public String getrefresco() {
	
	 return refresco;
	
	 }


	 public String toString() {
	
		String resultado="";
	
	
		 //Solo burger
		
		 if ((!burger.contentEquals("")) && (company.contentEquals("")) &&
		(refresco.contentEquals(""))) {
		
		 resultado = burger;
		
		 }
		
		
		 //Solo acompañamiento
		
		 if ((burger.contentEquals("")) && (!company.contentEquals("")) &&
		(refresco.contentEquals(""))) {
		
		 resultado = company;
		
		 }
		
		
		 //Solo refresco
		
		 if ((burger.contentEquals("")) && (company.contentEquals("")) &&
		(!refresco.contentEquals(""))) {
		
		 resultado = refresco;
		
		 }
		
		
		 //Solo burger + acompañamiento
		
		 if ((!burger.contentEquals("")) && (!company.contentEquals("")) &&
		(refresco.contentEquals(""))) {
		
		 resultado = burger + " acompañado con " + company;
		
		 }
		
		
		 //Solo burger + refresco
		
		 if ((!burger.contentEquals("")) && (company.contentEquals("")) &&
		(!refresco.contentEquals(""))) {
		
		 resultado = burger + " regado con " + refresco;
		
		 }
		
		
		 //Solo acompañamiento + refresco
		
		 if ((burger.contentEquals("")) && (!company.contentEquals("")) &&
		(!refresco.contentEquals(""))) {
		
		 resultado = company + " regado con " + refresco;
		
		 }
		
		
		 //Todo: burger + acompañamiento + refresco
		
		 if ((!burger.contentEquals("")) && (!company.contentEquals("")) &&
		(!refresco.contentEquals(""))) {
		
		 resultado = burger + " acompañado con " + company + " y regado con " + refresco;
		
		 }
	
	
		 return "Tu pedido es: " + resultado;
	
	 }
}
