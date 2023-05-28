function add() {
    window.location.href = "add.html"
}

function delProduct(id) {
    if (confirm('是否确认删除？')) {
        window.location.href = 'product.do?id=' + id + '&operate=del';
    }
}

function edit(id) {
    window.location.href = 'product.do?id=' + id + '&operate=edit';
}

function page(pageNo) {
    window.location.href = "product.do?pageNo=" + pageNo;
}
