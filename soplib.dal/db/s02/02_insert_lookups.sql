insert into change_types values (1, curdate(), curdate(), 'Publication');
insert into change_types values (2, curdate(), curdate(), 'Update');

insert into book_statuses values (1, curdate(), curdate(), 'Visible');
insert into book_statuses values (2, curdate(), curdate(), 'NeedPublished');
insert into book_statuses values (3, curdate(), curdate(), 'NeedUpdate');