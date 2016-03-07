<div class="content">
	<h3>Add child "{{companyChildName}}" company</h3>
	<div class="input">
		<form ng-submit="onSaveChildCompany()">
			<input type="text" ng-model="companyName" class="form-control" placeholder="Company name" required />
			<input type="text" ng-model="estimatedEarnings" class="form-control" placeholder="Estimated earnings" required />
			<input type="submit" class="btn btn-default btn-lg" style="margin-top: 10px;"  value="Add" />
		</form>
	</div>
</div>
