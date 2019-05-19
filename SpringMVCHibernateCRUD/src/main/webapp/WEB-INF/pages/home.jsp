<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
  
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
tr:hover {background-color: #f5f5f5;}

a{
	font-family: Verdana;
	font-size: 14px;
}

/* unvisited link */
a:link {
  color: purple;
}

/* visited link */
a:visited {
  color: darkblue;
}

/* mouse over link */
a:hover {
  color: gray;
}

/* selected link */
a:active {
  color: blue;
}
</style>

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Management Screen</title>
</head>
<body>

                    <strong class="card-title"><font style="font-family: "Times New Roman", Times, serif; font-size: 30px;" size="6">Stock Details</font></strong><br/><br/><br/><br/><br/>

                  <table align="center">
            <thead>
               <tr>
                
                 <th scope="col" align="center">Item Name</th>
                 <th scope="col" align="center">Brand</th>
                 <th scope="col" align="center">Quantity</th>
                 <th scope="col" align="center">Color</th>
                 <th scope="col" align="center">Edit / Update</th>                  
               </tr>
             </thead>
 
            <c:forEach var="item" items="${listItem}">
                <tr>
 
                    <td scope="col" align="center">${item.name}</td>
                    <td scope="col" align="center">${item.brand}</td>
                    <td scope="col" align="center">${item.qty}</td>
                    <td scope="col" align="center">${item.color}</td>
                    <td scope="col" align="center"><a href="editItem?id=${item.id}" style="text-decoration: none;">Edit</a>
                             / <a href="deleteItem?id=${item.id}" style="text-decoration: none;">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table><br/><br/><br/>
        
        <a href="newItem" style="text-decoration: none; font-size: 20px;">Add New Item</a>
            
      
        
    </div>
</body>
</html>