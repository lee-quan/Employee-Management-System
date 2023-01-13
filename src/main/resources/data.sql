ADD INDEX `branch_id_idx` (`branch_id` ASC) VISIBLE;
;
ALTER TABLE `jeewaeducation`.`departments` 
ADD CONSTRAINT `branch_id`
  FOREIGN KEY (`branch_id`)
  REFERENCES `branches` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `users` 
ADD INDEX `department_id_idx` (`department_id` ASC) VISIBLE;
;
ALTER TABLE `users` 
ADD CONSTRAINT `department_id`
  FOREIGN KEY (`department_id`)
  REFERENCES `departments` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (1,'6381072507','Apt 1495','umarney0@washington.edu','+62 407 909 6823','Karstens','Hansons','47558');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (2,'7973107921','Apt 460','wcaldecourt1@rambler.ru','+62 870 155 8958','Debs','Northwestern','87157');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (3,'4383472527','PO Box 45900','bcrowcombe2@qq.com','+251 345 894 2904','Spohn','Summerview','18885');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (4,'6278867417','10th Floor','rvanvelde3@purevolume.com','+56 357 267 3262','Jay','Elka','67138');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (5,'4023689225','Room 190','cgerssam4@reuters.com','+7 562 977 3341','Namekagon','Novick','19519');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (7,'2112312321','wqewqewqe','wqewqewqew@gmail.com','123213213','KL','KLIA','07000');

INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (1,'marketing231@gmail.com','Marketing','asdasdsadas asd asd sadsadas','Hansons','213213213','21321321',1);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (2,'marketing231@gmail.com','Marketing','asdasdsadas asd asd sadsadas','Northwestern','21321e2w23','1232131',2);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (3,'saleassadasd@gmail.com','Sales','wqeqwe','Elka','213213214','213213',4);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (6,'sales@gmail.comqweqe','Sales','1wqewqewqewq','Hansons','wqweeqwewqewq','213213123',1);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (8,'sales@gmail.comqweqe','Sales','1wqewqewqewq','KLIA','213123123','213213123',7);


INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (1,'qwewqeqwewqe',0,'2023-01-01','Marketing, Hansons',1,'Admin','admin@gmail.com',1,'Admin','Female','2023-01-01','Admin','123213','123213213','$2a$10$yFgtGkrBnp9q/yopl4L6NerEXacCQ3H6n9ZYgHpoFA9VsmJUQWdp2','admin',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (3,'qwewqewqewqdwqdwq',0,'2023-01-01','Marketing, Hansons',1,'Manager','cwq2000@gmail.com',1,'Wei Qian','Male','2023-01-01','Chong','21321321','321321321312321312','$2a$10$z6Mqwb7PHgkQ/itqFJm3ceRAhJDKDNE/j3DFgpaklQocpCbpUKhoy','cwq2000@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (4,'ewqewqewqewqeqwewq',0,'2023-01-01','Marketing, Northwestern',2,'Manager','lwk2000@gmail.com',1,'Won Khong','Male','2023-01-11','Lim','312312312321','21312321312','$2a$10$bkfLPPOjtHRQI6OUeSsj7OvK.O1I9413zDf10zYnFEGng93yty/o2','lwk2000@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (5,'qwewqewqeqwe',0,'2022-12-01','Sales, Hansons',6,'Manager','ql@gmail.com',1,'Quan','Male','2023-01-11','Lee','321312321','12321321321','$2a$10$oN3v/kvWpfTKfh8a6szFq.5d3pQF9cc27lMi/VgEr/pqZGpKgGu7G','ql@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (6,'qwewqewqewqewq',0,'2023-01-01','Marketing, Northwestern',2,'Manager','ali@gmail.com',1,'AliAbuHooray','Male','2023-01-11','Abu','123123213','213213213','$2a$10$z6Mqwb7PHgkQ/itqFJm3ceRAhJDKDNE/j3DFgpaklQocpCbpUKhoy','ali@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (8,'wqewqewqeqwe',0,'2023-01-01','Sales, Hansons',6,'Manager','testt@gmail.com',1,'Quan','Male','2023-01-01','test','213123123','21321321321','$2a$10$sOi2F5PWc9Y57w1K5M0uBO20xIdWLhD3Do0T4tM/Ar388D.eXMBbS','testt@gmail.com',0);

INSERT INTO `roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `roles` (`role_id`, `name`) VALUES ('2', 'EMPLOYEE');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

