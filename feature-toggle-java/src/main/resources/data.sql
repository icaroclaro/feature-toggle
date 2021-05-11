INSERT INTO FEATURE (name, description, last_date) VALUES ('PAGCARTAOCREDITO', 'Pagamento com cartão de crédito', '2019-05-05 18:00:00')
INSERT INTO FEATURE (name, description, last_date) VALUES ('PAGCARTAODEBITO', 'Pagamento com cartão de débito', '2019-05-05 18:00:00')
INSERT INTO FEATURE (name, description, last_date) VALUES ('PAGBOLETO', 'Pagamento via boleto', '2019-05-05 18:00:00')


INSERT INTO TOGGLE (status_code, description, last_date) VALUES ('S', 'Habilitado', '2019-05-05 18:00:00')
INSERT INTO TOGGLE (status_code, description, last_date) VALUES ('N', 'Não Habilitado', '2019-05-05 18:00:00')
INSERT INTO TOGGLE (status_code, description, last_date) VALUES ('M', 'Parcialmente Habilitado', '2019-05-05 18:00:00')

INSERT INTO FEATURE_TOGGLE (id, feature, toggle) VALUES ('1234567890', 'PAGCARTAOCREDITO', 'S')
INSERT INTO FEATURE_TOGGLE (id, feature, toggle) VALUES ('1234567891', 'PAGCARTAODEBITO', 'S')
INSERT INTO FEATURE_TOGGLE (id, feature, toggle) VALUES ('1234567892', 'PAGBOLETO', 'S')