//每次点击验证码图片更新验证码
function change(img) {
    img.src = "/user_code" + "?" + new Date().getTime();
}

//添加一个购物车对象
function cartAdd(type, id) {
    if (!$(".categ p").hasClass("on")) {
        $(".proIntro").css("border", "1px solid #c10000");
        $(".num .please").show()
    } else {
        let count = document.getElementById("count").innerHTML;
        location.replace("/cart_add" + "?" + "type=" + type + "&" + "id=" + id + "&" + "count=" + count);
    }
}

//更新用户个人信息
function saveInfo() {
    document.getElementById("save").removeAttribute("disabled")
}

//对商品进行排序显示
function sort(formId) {
    let form = document.getElementById(formId);
    form.submit();
}

//删除一个购物车对象
function deleteOne(msg, url) {
    if (confirm(msg)) {
        location.replace(url);
    }
}

//删除多个购物车对象
function deleteBatch(msg, formId) {
    if (confirm(msg)) {
        let form = document.getElementById(formId);
        form.submit();
    }
}

//提交订单
function getOrder() {
    let cartList = [];
    $("input[name='ids']:checked").each(function () {
        cartList.push($(this).val());
    });
    if (cartList.length !== 0) {
        location.replace("/order_get" + "?" + "cartList=" + cartList);
    }
}
