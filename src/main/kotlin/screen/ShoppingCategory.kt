package screen

import extensions.getNotEmptyString

class ShoppingCategory : Screen() {
    fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        val selectedCategory = readLine().getNotEmptyString()
//        while (selectedCategory.isNullOrBlank()) {
//            println("값을 입력해주세요")
//            selectedCategory = readLine()
//        }
        if (selectedCategory == "#") {
            // TODO: 2022/05/14 장바구니 이동
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                // TODO: 2022/05/14 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            } else {
                // TODO: 2022/05/14 카테고리 목록에 없는 값을 입력하는 경우
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요.")
        showCategories()
    }
}