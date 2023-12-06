package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;

public interface ICateService {
	List<Category> findAllCate();
	void insert(Category category);
	void update(Category category);
	void delete(int cateid) throws Exception;
	List<Category> findByCategoryParentsID(int cateparentsid);
	int count();
	
//	public static void main(String[] args) throws Exception {
//	ICateService catepa = new CateServiceImpl();
//
//	CategoryParents capa = new CategoryParents();
//	capa.setCateParentsID(4);
////	capa.setCateParentsName("Đồ Nhập Khẩu");
////	capa.setState(0);
//	Category cate = new Category();
//	cate.setCateID(28);
//	cate.setCateName("testaddca1112	");
//	cate.setCateParent(capa);
////	cateparents.setCateParentsName("test");
////	cateparents.setState(0);
////	catepa.insert(cateparents);
//
//	// cateparents.setCateParentsID(7);
//	// cateparents.setCateParentsName("not test");
//	// catepa.update(cateparents);
//
//	// int id = 8;
//	// try {
//	 catepa.update(cate);
//	// System.out.println("Xóa thành công!");
//	// } catch (Exception e) {
//	// e.printStackTrace();
//	// System.out.println("Xóa thất bại: " + e.getMessage());
//	// }
//
////	System.out.println(catepa.findAllCateParents());
//}
}
