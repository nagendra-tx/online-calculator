package resources;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;

public class CalcAction {

	public static void performCalculation(WebDriver driver, DataTable data) throws IOException {

		  String str_ConcatValue = "";
	        
	        for (int i = 0; i < data.cells().size(); i++) {
	        	 System.out.println(data.cell(i,1));
	        	 str_ConcatValue = str_ConcatValue.concat(data.cell(i,1));
	        }
	        
	    System.out.println(str_ConcatValue);
        driver.switchTo().frame(0);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	        String method = "\'"+str_ConcatValue+"\'.split('').forEach(\n"
	        		+ "  function(item, index){\n"
	        		+ "   var keycode = item.charCodeAt(0);\n"
	        		+ "    document.getElementById(\"canvas\").dispatchEvent(\n"
	        		+ "       new KeyboardEvent(\n"
	        		+ "         \"keypress\",{which: keycode, keyCode: keycode, bubbles:true}\n"
	        		+ "       )\n"
	        		+ "    )\n"
	        		+ "  }\n"
	        		+ ");";
	         js.executeScript(method);
	}
}
