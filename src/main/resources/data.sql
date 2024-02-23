/*
# Esta Query pobla la DB por defaul utilizando esta configuracion en aplication propetaries
'spring.sql.init.mode=always' pero debe tener en cuenta CAMBIAR EL ESTADO DE LA MISMA A
NEVER UNA VEZ LA POBLE Y QUE LA DB EXISTA,en el caso que no exista la DB no se iniciara la apps
y en caso que no cambie la anotacion cada vez que inicie el proyecto volvera a cargar los datos
a su DB  la tercera opcion es no ingresar la configuracion a properties y cargarlos de manera manual
*/


/* Esta Query iyecta datos de la Entidad Categories*/
INSERT INTO nocountry_db.categories
(category_id, available, name)
VALUES(1, 1, 'plomeria');
INSERT INTO nocountry_db.categories
(category_id, available, name)git
VALUES(2, 1, 'carpinteria');
INSERT INTO nocountry_db.categories
(category_id, available, name)
VALUES(3, 1, 'electricidad');
INSERT INTO nocountry_db.categories
(category_id, available, name)
VALUES(4, 1, 'albañileria');

/* Esta Query iyecta datos de la Entidad User Account*/
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(1, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(2, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(3, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(4, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(5, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(6, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(7, NULL);
INSERT INTO nocountry_db.user_accounts
(id, photo)
VALUES(8, NULL);

/* Esta Query iyecta datos de la Entidad User Auth*/
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(1, 'a@a.com', 'pedro', 'saavedra', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(2, 'b@b.com', 'juan', 'borda', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(3, 'c@c.com', 'diego', 'palacio', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(4, 'd@d.com', 'jose', 'pacheco', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(5, 'f@f.com', 'maria', 'ortiz', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(6, 'j@j.com', 'josefa', 'jara', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(7, 'k@k.com', 'laura', 'tapia', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(8, 'l@l.com', 'viki', 'medina', '1234', 'USER');
INSERT INTO nocountry_db.user_auth
(id, email, firstname, lastname, password, `role`)
VALUES(9, 'admin@email.com', 'admin', 'admin', 'admin1234', 'ADMIN');


/* Esta Query iyecta datos de la Entidad Professional Profile*/
INSERT INTO nocountry_db.professions
(id, at_home, available, details, price, title, category_id)
VALUES(1, 1, 1, 'detalle 1', 2500.00, 'oficio 1', 1);
INSERT INTO nocountry_db.professions
(id, at_home, available, details, price, title, category_id)
VALUES(2, 1, 1, 'detalle 2', 2548.50, 'oficio 2', 2);
INSERT INTO nocountry_db.professions
(id, at_home, available, details, price, title, category_id)
VALUES(3, 1, 1, 'detalle 3', 1500.80, 'oficio 3', 3);
INSERT INTO nocountry_db.professions
(id, at_home, available, details, price, title, category_id)
VALUES(4, 1, 1, 'detalle 4', 3000.90, 'oficio 4', 4);


/* Esta Query iyecta datos de la Entidad Review*/
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(1, 'description 1', 1);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(2, 'description 2', 2.5);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(3, 'description 3', 3);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(4, 'description 4', 1);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(5, 'description 5', 4);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(6, 'description 6', 5);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(7, 'description 7', 4.5);
INSERT INTO nocountry_db.reviews
(review_id, description, score)
VALUES(8, 'description 8 ', 2.9);


/* Esta Query iyecta datos de la Entidad ServiceHistory sin embargo faltan la FK de
   Contractor Profile se deben ingresar de manera directa en la DB usando el orden correlativo
   hasta el 4 despus comenzar otra vez desde 1 hasta el 4*/
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(1, '2023-12-02', 2594.0, null, 1, 1);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(2, '2023-12-02', 2500.0, null, 2, 2);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(3, '2023-12-020', 5000.0, null, 3, 3);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(4, '2024-12-02', 1500.0, null, 4, 4);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(5, '2024-11-02', 2000.0, null, 1, 5);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(6, '2023-10-01', 1000.0, null, 2, 6);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(7, '2023-12-07', 2444.0, null, 3, 7);
INSERT INTO nocountry_db.service_histories
(service_history_id, `date`, price, contractor_profile_id, professional_service_id, review_id)
VALUES(8, '2024-12-02', 2500.0, null, 4, 8);


/* Esta Query iyecta datos de la Entidad Contractor Profile por defecto la PK se creara, pero se debe
   insertar de manera manual la FK de location_location_id usando el correlativo del 1 al 4  */
INSERT INTO nocountry_db.contractor_profiles
(id, available, business_name, last_name, name, location_location_id, prof_service_id, user_account_id)
VALUES(null, 'YES', 'empresa 1', 'perez', 'pedro', null, 1, 1);
INSERT INTO nocountry_db.contractor_profiles
(id, available, business_name, last_name, name, location_location_id, prof_service_id, user_account_id)
VALUES(null, 'YES', 'empresa 2', 'pacheco', 'juan', null, 2, 2);
INSERT INTO nocountry_db.contractor_profiles
(id, available, business_name, last_name, name, location_location_id, prof_service_id, user_account_id)
VALUES(null, 'YES', 'empresa 3', 'jara', 'diego', null, 3, 3);
INSERT INTO nocountry_db.contractor_profiles
(id, available, business_name, last_name, name, location_location_id, prof_service_id, user_account_id)
VALUES(null, 'YES', 'empresa 4', 'tapia', 'jose', null, 4, 4);


/* Esta Query iyecta datos en la tabla contractor_profile_services_history*/
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(1, 1);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(2, 2);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(3, 3);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(4, 4);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(1, 5);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(2, 6);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(3, 7);
INSERT INTO nocountry_db.contractor_profiles_services_history
(contractor_profiles_id, services_history_service_history_id)
VALUES(4, 8);


/* Esta Query iyecta datos de la Entidad Location*/
INSERT INTO nocountry_db.locations(location_id, comuna, direccion, numero, city, country, contractor_profile_id)
VALUES(1, 'a', 'agagaga', '125', 'mar del plata', 'argentina', 1);
INSERT INTO nocountry_db.locations
(location_id, comuna, direccion, numero, city, country, contractor_profile_id)
VALUES(2, 'b', 'hahahah', '1224', 'mar del plata', 'argentina', 2);
INSERT INTO nocountry_db.locations
(location_id, comuna, direccion, numero, city, country, contractor_profile_id)
VALUES(3, 'c', 'hahahaha', '125', 'mar del plata', 'argentina', 3);
INSERT INTO nocountry_db.locations
(location_id, comuna, direccion, numero, city, country, contractor_profile_id)
VALUES(4, 'd', 'hahahaha', '1224', 'mar del plata', 'argentina', 4);










