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

INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (1,'+6039096822','Apt 1495, Lorong Happy, Damansara Hike','umarney0@washington.edu','+6039096823','Karstens','Hansons','47500');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (2,'+6031558957','Apt 460, Jalan Oneone, Taman Jana','wcaldecourt1@rambler.ru','+6031558958','Debs','Northwestern','37100');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (3,'+6058942903','23, Seksyen 17, Taman 11/2','bcrowcombe2@qq.com','+6058942904','Spohn','Summerview','45900');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (4,'+6042673261','10-22, Mary Lane, Latitude Garden','rvanvelde3@purevolume.com','+6042673262','Jay','Elka','67100');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (5,'+6059773340','170, Jalan 4, Design Park','cgerssam4@reuters.com','+6059773341','Namekagon','Novick','35100');
INSERT INTO `branches` (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (7,'+6091124567','L3, Jalan Samathra, Anthory Garden','kliabranch@gmail.com','+6091124568','KL','KLIA','57000');

INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (1,'marketing231@gmail.com','Marketing','Level 1','Hansons','2133','+6052225125',1);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (2,'marketing231@gmail.com','Marketing','2nd Floor','Northwestern','2544','+6032555451',2);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (3,'saleassadasd@gmail.com','Sales','R-12-05','Elka','1134','+6035884112',4);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (6,'sales@gmail.comqweqe','Sales','Level 1','Hansons','8824','+6012355565',1);
INSERT INTO `departments` (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`,`branch_id`) VALUES (8,'sales@gmail.comqweqe','Sales','L3-10','KLIA','2823','+6036523454',7);


INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (1,'2, Jalan Mutiara 11, Taman Mutiara, 36100 Ipoh, Perak.',0,'2023-01-01','Marketing, Hansons',1,'Admin','admin@gmail.com',1,'Admin','Female','2023-01-01','Admin','+60145558956','690207081111','$2a$10$yFgtGkrBnp9q/yopl4L6NerEXacCQ3H6n9ZYgHpoFA9VsmJUQWdp2','admin',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (3,'K3C, Happy Condominium, Jalan 12/2, 46100 Petaling Jaya, Selangor.',0,'2023-01-01','Marketing, Hansons',1,'Manager','cwq2000@gmail.com',1,'Wei Qian','Male','2023-01-01','Chong','+60121321321','971120016565','$2a$10$z6Mqwb7PHgkQ/itqFJm3ceRAhJDKDNE/j3DFgpaklQocpCbpUKhoy','cwq2000@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (4,'20A, Lorong B/Alans, Taman Tiana, 52100 Kuala Lumpur.',0,'2023-01-01','Marketing, Northwestern',2,'Manager','lwk2000@gmail.com',1,'Won Khong','Male','2023-01-11','Lim','+60175553216','920621071113','$2a$10$bkfLPPOjtHRQI6OUeSsj7OvK.O1I9413zDf10zYnFEGng93yty/o2','lwk2000@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (5,'25, Jalan 11/1, Ra Garden, 53100 Kuala Lumpur.',0,'2022-12-01','Sales, Hansons',6,'Manager','ql@gmail.com',1,'Quan','Male','2023-01-11','Lee','+60132225698','990128084521','$2a$10$oN3v/kvWpfTKfh8a6szFq.5d3pQF9cc27lMi/VgEr/pqZGpKgGu7G','ql@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (6,'3A-22, ABC Apartment, Seksyen 11, 43500 Petaling Jaya, Selangor.',0,'2023-01-01','Marketing, Northwestern',2,'Manager','ali@gmail.com',1,'AliAbuHooray','Male','2023-01-11','Abu','+60184545231','901209021554','$2a$10$z6Mqwb7PHgkQ/itqFJm3ceRAhJDKDNE/j3DFgpaklQocpCbpUKhoy','ali@gmail.com',0);
INSERT INTO `users` (`user_id`,`address`,`avg`,`birthday`,`department`,`department_id`,`designation`,`email`,`enabled`,`first_name`,`gender`,`joined_date`,`last_name`,`mobile_number`,`nic`,`password`,`username`,`branch_id`) VALUES (8,'&, Jalan Ken 2, Taman Array, 06000 Alor Setar, Kedah.',0,'2023-01-01','Sales, Hansons',6,'Manager','testt@gmail.com',1,'Quan','Male','2023-01-01','test','+60132223658','730514032125','$2a$10$sOi2F5PWc9Y57w1K5M0uBO20xIdWLhD3Do0T4tM/Ar388D.eXMBbS','testt@gmail.com',0);

INSERT INTO `roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `roles` (`role_id`, `name`) VALUES ('2', 'EMPLOYEE');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

