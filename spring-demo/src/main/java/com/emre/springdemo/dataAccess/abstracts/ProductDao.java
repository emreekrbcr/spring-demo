package com.emre.springdemo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	//Bu alttaki metodların somutunu implement etmeye gerek yok. 
	//Spring metod isminden yola çıkarak otomatik buluyormuş.
	//Ama getByProductName gibi standart bir isim vermek önemli!
	
	//Burada önceki metoddaki isimleri CategoryId şeklinde yapmıştık ancak daha ORM yapıp, ilişkiler üzerinden
	//ilerlemek istediğimiz için Product class'ında Category ile ilişki oluşturduk. Dolayısıyla artık metodlara
	//bunun adını yazmamız gereklidir. Ancak Business'taki metodlarda değişiklik yapma onlar getByCategoryIdIn 
	//gibi içerisinde Id ismi kalacak(sorun başka yerden kaynaklı CategoryId diye de yapabiliriz ama daha doğrusu
	//Category'nin id'si old. belirtmek için Category_Id şeklinde isimlendirmek)
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_Id(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_Id(String productName, int categoryId);
	
	List<Product> getByCategory_IdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//Aşağıdaki annotation sayesinde JPQL yazmış oluruz. bunu yazarken Product veritabanındaki tablo adı 
	//değil bizim javadaki entity'nin ismidir. :'dan önce entity'nin, sonrası metodun parametresindeki değerdir
	//Java'da LINQ gibi gelişmiş bir yapı yok ama bu var
	
	//Product içerisindeki categoryId'yi kaldırdığımız ve ilişki üzerinden Category oluşturduğumuz için aşağıdaki
	//sorguda category.id= şeklinde oldu yoksa hata alırız. Yani Product içerisindeki category nesnesinin id'si
	
	@Query("From Product where productName=:productName and category.id=:categoryId")
	List<Product> getByProductNameAndCategory_IdCustom(String productName, int categoryId);
	
	//Alttaki gibi Dto'lar için sorgu yazılırken one to many'nin one tarafındaki önce base tablomuzu yazsak daha iyi olurmuş
	//Yani Category-Product için önce Category'i yazmak gibi. Dto'larda tüm join'deki sütunları değil de belirli
	//bir kısmını çekmek için yine Select'le başlamak gerekir. Eğer tüm sütunları getireceksek yukarıdaki gibi
	//From'la başlanır. Burası normal sql'den biraz farklı. Entity'lerimiz üzerinden sorguyu yazıyoruz ve on koşulu yazmadık çünkü zaten
	//products nesnesini Category class'ında ilişkilendirmiştik
		
	@Query("Select new com.emre.springdemo.entities.dtos.ProductWithCategoryDto(p.id, p.productName, "
			+ "c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
