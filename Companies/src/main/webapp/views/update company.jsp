<div class="content">
	<h3>Update "{{name}}" company</h3>
	<div class="input" style="width: 380px;">
		<form ng-submit="updateCompany()">
			<div style="text-align: left; display: inline-block; vertical-align: top; padding-top: 10px;">
				<span style="font-size: 18px;">Company name</span>
				<br>
				<span style="font-size: 18px; margin-top: 11px; display: block;">Estimated earnings</span>
			</div>
			<div style="display: inline-block; text-align: left;">
				<input type="text" ng-model="companyName" class="form-control" required value="{{companyName}}" style="display: inline-block; width: 200px; margin-left: 10px;"/>
				<br>
				<input type="text" class="form-control" ng-model="estimatedEarnings" required value="{{estimatedEarnings}}" style="display: inline-block; width: 200px; margin-left: 10px;">
			</div>
			<input type="submit" class="btn btn-default btn-lg" style="margin-top: 10px;" value="Update">
		</form>
	</div>
</div>
