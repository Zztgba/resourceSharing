$(function () {
    //改变被选中页码的样式
    var urlstr = location.href;
    var urlstatus=false;
    $(".panigation a").each(function () {
        if ((urlstr + '/').indexOf($(this).attr('href')) > -1&&$(this).attr('href')!='') {
            $(this).addClass('act'); urlstatus = true;
        } else {
            $(this).removeClass('act');
        }

    });
    if (!urlstatus) {
        $(".panigation a").eq(0).addClass('act');
    }
});