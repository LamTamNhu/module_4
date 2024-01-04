let currentPage = 10;
$(document).ready(function () {
    getAllBlogs();
})

function display(data) {
    let blogs = data.content;
    console.log("length: " + blogs.length)
    let table = `<table id="blog">
            <thead>
            <tr>
                <th>No.</th>
                <th>Title</th>
                <th>Date</th>
                <th>Action</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>`;
    for (let i = 0; i < blogs.length; i++) {
        table += `<tr>
<td>${i + 1}</td>
<td>${blogs[i].title}</td>
<td>${blogs[i].dateTimePublished}</td>
<td>
<a class="btn btn-info text-light" href="/view/${blogs[i].id}" "> View </a>
</td>
<td>
<a class="btn btn-info text-light" href="/edit/${blogs[i].id}" "> Edit </a>
</td>
<td>
                <a type="button" th:attr="onclick=|onDeleteHandler('${blogs[i].id}','${blogs[i].title}')|"
                   class="btn btn-danger"
                   data-bs-toggle="modal" data-bs-target="#deleteModal">
                    Delete
                </a>
            </td>
</tr> `;
    }
    table += "</table>"
    $("#blogs-table").html(table);
}

function getAllBlogs() {
    $.get("http://localhost:8080/api/blogs?page=0&size=" + currentPage, function (data, status) {
            display(data);
        }
    )
}

$("#search_form").submit(function (e) {
    e.preventDefault();
    let form = $(this);
    let actionUrl = form.attr('action') + "?" + form.serialize();
    console.log(actionUrl)
    $.get(actionUrl, function (data) {
        console.log("search data: " + data)
        display(data)
    })
});
$(window).on("scroll", function () {
    let scrollHeight = $(document).height();
    let scrollPosition = $(window).height() + $(window).scrollTop();
    if (scrollHeight - scrollPosition < 10) {
        console.log("current page: " + currentPage)
        currentPage += 10;
        getAllBlogs();
    }
});