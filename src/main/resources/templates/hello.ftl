<#import "parts/common.ftl" as common/>

<@common.page>

<div>
    <form method="post">
        <input type="text" name="name" placeholder="Name"/>
        <input type="number" name="count" placeholder="Count"/>
        <input type="text" name="password" placeholder="Password"/>
        <input type="text" name="description" placeholder="Description"/>
        <button type="submit">Add unit</button>
    </form>
    <br>
    <form action="file" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <input type="submit" value="Load file"></p>
    </form>
</div>
<div>
    <h3>Units</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Count</th>
        <th>Description</th>
        <th>Activity</th>
        <th>update</th>
    </tr>

    <#list units as units>
    <tr>
        <td>${units.name}</td>
        <td>${units.count}</td>
        <td>${units.description}</td>
        <td>${units.isactive?string('yes', 'no')}</td>
        <td><a href="/update/${units.id}"/>Update</td>
    </tr>

    </#list>
</table>

</div>
</@common.page>

