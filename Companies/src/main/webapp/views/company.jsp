<div style="width: 500px; display: inline-block;">
	<br>
	<a href="#/addChildCompany/{{idCompany}}">Add child company</a>
	<br>
	<a href="#/" style="display: inline-block; margin-bottom: 5px;">Back</a>
	<div ng-bind="message"></div>
	<table class="myTable myTable-hover" style="margin-top: 10px;">
		<thead>
			<tr>
				<th>Company name</th>
				<th>Estimated earnings</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td ng-bind="companyName"></td>
 				<td ng-bind="estimatedEarnings"></td>
				<td class="noHover">
					<a href="#/removeCompany/{{idCompany}}" class="remove"></a>
					<a href="#/updateCompany/{{idCompany}}" class="edit"></a>
				</td>
			</tr>
		</tbody>
	</table>
</div>