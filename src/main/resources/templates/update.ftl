<#import "parts/common.ftl" as common/>

<@common.page>
    <div>
        <form method="post">
            <input type="text" name="name" value="${unit.name}"/>
            <input type="number" name="count" value="${unit.count}"/>
            <input type="text" name="password" value="${unit.password}"/>
            <input type="text" name="description" value="${unit.description}"/>
            <select class="ml-1" name="activ" [(ngModel)]="activeStatus">
                <option [ngValue]="true" value="true">Active</option>
                <option [ngValue]="false" value="false">Not Active</option>
            </select>
            <button type="submit">Update unit</button>
            <br/>
            <br/>
            <a href="/delete/${unit.id}">Delete unit</a>
        </form>
    </div>
</@common.page>