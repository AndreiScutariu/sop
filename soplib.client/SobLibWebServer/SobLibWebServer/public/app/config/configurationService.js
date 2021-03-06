﻿ (function (module) {

	module.service('configurationService', function () {
		this.baseEnpoint = 'http://localhost:8080';
		this.rolesEndpoint = this.baseEnpoint + '/soplib-restws/api/roles';
		this.tockenProviderEndpoint = this.baseEnpoint + '/soplib-restws/api/generatetoken';
		this.booksEndpoint = this.baseEnpoint + '/soplib-restws/api/books';
		this.usersEndpoint = this.baseEnpoint + '/soplib-restws/api/users';
		this.buildEndpoint = function (uri) {
			return this.baseEnpoint + uri;
		};
		this.books = {
			base: this.booksEndpoint,
			search: this.booksEndpoint + "/search",
			publish:  this.booksEndpoint + "/publish"
		};
	});

})(angular.module('app'));
