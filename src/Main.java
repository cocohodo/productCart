import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
class Product {
    private static int count = 0;
    private int key = 0;
    private String name = "";
    private int price = 0;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Product(String name, int price) {
        this.key = ++count;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
        hashCode = prime * hashCode + key;

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return this == obj;
    }

}
class Cart {
    HashMap<Product, Integer> items = new HashMap<>();
    public void addProduct(Product item,int num) {
        items.put(item,items.getOrDefault(item,0)+num);
    }
    public void removeProduct(Product item,int num) {
        items.put(item,items.getOrDefault(item,0)-num);
        if(items.getOrDefault(item,0)<=0) items.remove(item);
    }
    public void showItems() {
        items.forEach((key, value) -> {
            System.out.println(key.getName() + " : " + value+"개");
        });
    }
}

public class Main {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        // TODO: 상품 목록을 생성하여 상품들을 목록에 넣는다.
        Product item1 = new Product("사과",100);
        Product item2 = new Product("연필",200);
        Product item3 = new Product("사과",300);
        productSet.add(item1);
        productSet.add(item2);
        productSet.add(item3);

        //같은지 확인
        System.out.println(item1.equals(item3));

        // 상품 목록 출력
        System.out.println("구매한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();
        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(item1,2);
        myCart.addProduct(item1,2);
        myCart.addProduct(item2,7);
        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct(item1,2);
        // TODO: 장바구니에 담긴 모든 상품을 출력 (상품이름, 각 상품의 가격)
        System.out.println("장바구니 상품 목록:");
        myCart.showItems();
    }
}
