//全选本页商品
function selectAll(box) {
    let list = document.getElementsByName("ids");
    for (let i = 0; i < list.length; i++) {
        list[i].checked = box.checked;
    }
}

//删除一个商品
function deleteOne(msg, url) {
    if (confirm(msg)) {
        location.replace(url);
    }
}

//删除多个商品
function deleteBatch(msg, formId) {
    if (confirm(msg)) {
        let form = document.getElementById(formId);
        form.submit();
    }
}

//发送邮件
function sendOne(msg, url) {
    if (confirm(msg)) {
        location.replace(url);
    }
}



