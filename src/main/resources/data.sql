ADD INDEX `branch_id_idx` (`branch_id` ASC) VISIBLE;
;
ALTER TABLE `jeewaeducation`.`departments` 
ADD CONSTRAINT `branch_id`
  FOREIGN KEY (`branch_id`)
  REFERENCES `jeewaeducation`.`branches` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `jeewaeducation`.`users` 
ADD INDEX `department_id_idx` (`department_id` ASC) VISIBLE;
;
ALTER TABLE `jeewaeducation`.`users` 
ADD CONSTRAINT `department_id`
  FOREIGN KEY (`department_id`)
  REFERENCES `jeewaeducation`.`departments` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



INSERT INTO `jeewaeducation`.`users` (`user_id`, `enabled`, `password`, `username`, `avg`) VALUES (1, 1, '$2a$10$yFgtGkrBnp9q/yopl4L6NerEXacCQ3H6n9ZYgHpoFA9VsmJUQWdp2', 'admin', 0);
INSERT INTO `Jeewaeducation`.`roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `Jeewaeducation`.`roles` (`role_id`, `name`) VALUES ('2', 'EMPLOYEE');
INSERT INTO `Jeewaeducation`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO branches (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (1,'6381072507','Apt 1495','umarney0@washington.edu','+62 407 909 6823','Karstens','Hansons','47558');
INSERT INTO branches (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (2,'7973107921','Apt 460','wcaldecourt1@rambler.ru','+62 870 155 8958','Debs','Northwestern','87157');
INSERT INTO branches (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (3,'4383472527','PO Box 45900','bcrowcombe2@qq.com','+251 345 894 2904','Spohn','Summerview','18885');
INSERT INTO branches (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (4,'6278867417','10th Floor','rvanvelde3@purevolume.com','+56 357 267 3262','Jay','Elka','67138');
INSERT INTO branches (`id`,`bphone_number`,`branch_address`,`branch_email`,`branch_fax_no`,`branch_location`,`branch_name`,`branch_p_code`) VALUES (5,'4023689225','Room 190','cgerssam4@reuters.com','+7 562 977 3341','Namekagon','Novick','19519');

INSERT INTO departments (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`) VALUES (1,'marketing231@gmail.com','Marketing','asdasdsadas asd asd sadsadas','Hansons','213213213','21321321');
INSERT INTO departments (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`) VALUES (2,'marketing231@gmail.com','Marketing','asdasdsadas asd asd sadsadas','Northwestern','21321e2w23','1232131');
INSERT INTO departments (`id`,`department_email`,`department_name`,`department_address`,`department_branch`,`department_entention_no`,`dphone_number`) VALUES (3,'saleassadasd@gmail.com','Sales','wqeqwe','Elka','213213214','213213');

