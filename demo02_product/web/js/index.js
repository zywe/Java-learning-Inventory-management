function delFruit(fid){
    if(confirm('是否确认删除？')){
        window.location.href='product.do?id='+id+'&operate=del';

    }
}

function page(pageNo) {
    window.location.href="product.do?pageNo="+pageNo;
}
