function add() {
    window.location.href = "add.html"
}


// product.do?operate=adminIndex&pageNo=3


function delProduct(id) {
    if (confirm('是否确认删除？')) {
        window.location.href = 'admin.do?id=' + id + '&operate=del';
    }
}

function edit(id) {
    window.location.href = 'admin.do?id=' + id + '&operate=edit';
}

function page(pageNo) {
    window.location.href = "admin.do?pageNo=" + pageNo;
}
