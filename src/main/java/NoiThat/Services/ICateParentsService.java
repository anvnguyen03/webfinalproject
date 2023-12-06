package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.CategoryParents;

public interface ICateParentsService {

	List<CategoryParents> findAllCateParents();

	void insert(CategoryParents cateParents);

	void update(CategoryParents cateparents);

	void delete(CategoryParents cateparents) throws Exception;

//	public static void main(String[] args) throws Exception {
//		ICateParentsService catepa = new CateParentsServiceImpl();
//
//		CategoryParents cateparents = new CategoryParents();
////		cateparents.setCateParentsName("test");
////		cateparents.setState(0);
////		catepa.insert(cateparents);
//
//		// cateparents.setCateParentsID(7);
//		// cateparents.setCateParentsName("not test");
//		// catepa.update(cateparents);
//
//		// int id = 8;
//		// try {
//		 catepa.delete(17);
//		// System.out.println("Xóa thành công!");
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// System.out.println("Xóa thất bại: " + e.getMessage());
//		// }
//
////		System.out.println(catepa.findAllCateParents());
//	}
}
