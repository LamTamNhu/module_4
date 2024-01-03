// function search() {
//     $.get("/api/blogs/", function (blogs, status) {
//         let table = `<table id="blog">
//             <thead>
//             <tr>
//                 <th>No.</th>
//                 <th>Title</th>
//                 <th><a className="text-decoration-none" th:href="${sort}">Publish
//                     Date</a></th>
//                 <th></th>
//                 <th></th>
//                 <th></th>
//             </tr>
//             </thead>
//             <tbody>`;
//         for(let i=0;i<blogs.length;i++){
//             table+=`<tr>
//
// </tr>>`
//         }
//             <tr th:each="blog,b : ${blogs}">
//                 <td th:text="${b.count}"></td>
//                 <td th:text="${blog.title}"></td>
//                 <td th:text="${blog.dateTimePublished}"></td>
//                 <td>
//                     <a className="btn btn-info text-light" th:href="@{/view/{id}(id=${blog.id})}"> View </a>
//                 </td>
//                 <td>
//                     <a className="btn btn-primary" th:href="@{/edit/{id}(id=${blog.id})}"> Edit </a>
//                 </td>
//                 <td>
//                     <a type="button" th:attr="onclick=|onDeleteHandler('${blog.id}','${blog.title}')|"
//                        className="btn btn-danger"
//                        data-bs-toggle="modal" data-bs-target="#deleteModal">
//                         Delete
//                     </a>
//                 </td>
//             </tr>
//             </tbody>
//         </table>
//         }
//     )
// }