package screen

import extensions.getNotEmptyString

/*
* 개념 4-1. 컬렉션
* 개념 4-2. object, companion object
* 개념 4-3. Nested & Inner 클래스, Extension 함수 & Generic
* 개념 4-4. 함수 타입, 람다
* 개념 4-5. Scope 함수 : let, with, run, apply, also
Step 1. 장바구니에 추가한 상품 관리
Step 2. 사용자 입력값 요청 처리 공통화
Step 3. 프로젝트 전역에서 참조하는 함수
 */
class ShoppingCategory {

    fun showCategories() {
        /*
        개념 2-1. 사전 학습 : Null, Compiler
        개념 2-2. operator & if, when
        개념 2-3. operator & loop
        Step 1. 상품 카테고리 표기
        Step 2. 사용자 입력 받기
        Step 3. 사용자가 기대하는 값을 입력하지 않는 경우에 대한 처리
         */
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
            // TODO 1. 장바구니 이동
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                // TODO 2. 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                // TODO 3. 카테고리 목록에 없는 값을 입력하는 경우
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요.")
        showCategories()
    }
}