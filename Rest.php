<div style ="height: 350px;width: 50%;  background-color:skyblue ;margin-left: 300px;box-shadow: 10px 10px 5px ">
<br>
<h1 style ="margin-left: 200px;"> The  Civil Registry Wellcome <h1>
<h2 style ="margin-left: 30px;"> Search Civil   <h2>
<form action="" method="POST">
  xmlName<input   style ="margin-left: 150px "type="radio" name="key" value="1" > 
  jsonName<input type="radio" name="key" value="2"> 
 xmlId<input   type="radio" name="key" value="3" > 
  jasonId<input type="radio" name="key" value="4"> 
  <br>
  <br>
   User : 
   <input style ="margin-left: 40px" type="text" name="input"><br>
 <input style ="margin-left: 400px" type="submit" name = "submit" value="Search">
	</form>
	   
</div>


<?php

if(isset($_POST['submit'])){  
   $x = $_POST['key'];  
    if ($x == '1') {  
$name = $_POST['input'];
$url = "http://localhost:8080/AhmedWebApplicationRestFull/webresources/ahmedgeneric/xmlName/$name";
$civils = new SimpleXMLElement($url, null, true);

echo <<<EOF
<table border="2" bgcolor="pink" >
        <tr>
                <th>ID</th>
                <th>Fname</th>
                <th>Lname</th>
                <th>Nnumber</th>
        </tr>

EOF;
foreach($civils as $civil) // loop through our books
{
        echo <<<EOF
        <tr>
                <td>{$civil->id}</td>
                <td>{$civil->fname}</td>
                <td>{$civil->lname}</td>
                <td>{$civil->nnumber}</td>



        </tr>

EOF;
}
echo '</table>';
		 
}
 else 
	 if ($x == '2'){ 
                 $name = $_POST['input'];
		 $url = "http://localhost:8080/AhmedWebApplicationRestFull/webresources/ahmedgeneric/jsonName/$name";
	$json = file_get_contents($url);
	$json_o = json_decode($json);
	echo <<<EOF
<table border="2" bgcolor="pink" >
        <tr>
                <th>ID</th>
                <th>Fname</th>
                <th>Lname</th>
                <th>Nnumber</th>
        </tr>

EOF;
foreach($json_o->civils as $civil) // loop through our books
{
        echo <<<EOF
        <tr>
               <td>{$civil->id}</td>
                <td>{$civil->fname}</td>
                <td>{$civil->lname}</td>
                <td>{$civil->nnumber}</td>




        </tr>

EOF;
}
echo '</table>';
		 
	 }	 
	 

else 
	if($x == '3'){
		$id = $_POST['input'];
		$url ="http://localhost:8080/AhmedWebApplicationRestFull/webresources/ahmedgeneric/xmlId/$id";

$civils = new SimpleXMLElement($url, null, true);

echo <<<EOF
<table border="2" bgcolor="#00FF00" >
        <tr>
               <th>ID</th>
                <th>Fname</th>
                <th>Lname</th>
                <th>Nnumber</th>
        </tr>

EOF;
foreach($civils as $civil) // loop through our books
{
        echo <<<EOF
        <tr>
               <td>{$civil->id}</td>
                <td>{$civil->fname}</td>
                <td>{$civil->lname}</td>
                <td>{$civil->nnumber}</td>




        </tr>

EOF;
}
echo '</table>';


}
else
	
	 if ($x == '4'){
		 $id = $_POST['input'];
		$url = "http://localhost:8080/AhmedWebApplicationRestFull/webresources/ahmedgeneric/jsonId/$id";

$civils = new SimpleXMLElement($url, null, true);

echo <<<EOF
<table border="2" bgcolor="#00FF00" >
        <tr>
               <th>ID</th>
                <th>Fname</th>
                <th>Lname</th>
                <th>Nnumber</th>
        </tr>

EOF;
foreach($civils as $civil) // loop through our books
{
        echo <<<EOF
        <tr>
                <td>{$civil->id}</td>
                <td>{$civil->fname}</td>
                <td>{$civil->lname}</td>
                <td>{$civil->nnumber}</td>




        </tr>

EOF;
}
echo '</table>';



	 }
}  
?>
