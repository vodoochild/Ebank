from flask_sqlalchemy import SQLAlchemy
import logging as lg
from sqlalchemy_utils import database_exists, create_database, drop_database
from ..app import app
from sqlalchemy import create_engine




# Create database connection object
db = SQLAlchemy(app)
DB_URL = app.config['SQLALCHEMY_DATABASE_URI']
engine = create_engine(DB_URL)







class Client(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    number = db.Column(db.Integer, unique=True, nullable=False)
    firstName = db.Column(db.String(20), nullable=False)
    lastName = db.Column(db.String(20), nullable=False)
    bills = db.relationship('Bill', backref='client', lazy=True)


    def __init__(self, number, firstName, lastName ):
        self.number = number
        self.firstName = firstName
        self.lastName = lastName



class Bill(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    value = db.Column(db.Float, nullable=False)
    date = db.Column(db.String(20), nullable=False)
    paid = db.Column(db.Boolean, nullable=False)
    client_id = db.Column(db.Integer, db.ForeignKey('client.id'),nullable=False)


    def __init__(self, value, date, client_id, paid=False ):
        self.value = value
        self.date = date
        self.client_id = client_id
        self.paid = paid



print('---------------------------------------------------------------')
if database_exists(DB_URL):
    print('Deleting database.')
    drop_database(DB_URL)
if not database_exists(DB_URL):
    print('Creating database.')
    create_database(DB_URL)
lg.warning('data base exist now')
db.drop_all()
lg.warning('all tables are dropped')
db.create_all()
lg.warning('all tables are created')
db.session.add(Client(633333333,'Moad','SADDOUNE'))
db.session.add(Client(622222222, 'Tarek','RAHAL'))
db.session.add(Client(611111111, 'Ayoub', 'ELOUARAK'))
db.session.add(Client(644444444, 'Khawla', 'ELHADRI'))
db.session.add(Bill(100, '01/2019', 1))
db.session.add(Bill(125, '02/2019', 1))
db.session.add(Bill(200, '05/2019', 2))
db.session.add(Bill(155, '07/2019', 2))
db.session.add(Bill(520, '01/2019', 3))
db.session.add(Bill(677, '12/2019', 3))
db.session.add(Bill(421, '11/2019', 3))
db.session.add(Bill(120, '09/2019', 4))
db.session.add(Bill(205, '10/2019', 4))
db.session.commit()
lg.warning('Database initialized!')