from flask import Flask

app = Flask(__name__)
# Config options - Make sure you created a 'config.py' file.
app.config.from_object('config')
# To get one variable, tape app.config['MY_VARIABLE']


@app.route('/')
def index():
    return "Welcome in ENSA operator's Web service"


@app.route('/bills/<number>')
def get_bills(number):
    from .models.store import bills_toJson
    return bills_toJson(number)


@app.route('/bills/all/<number>')
def all_bills(number):
    from .models.store import all_bills_toJson
    return all_bills_toJson(number)


@app.route('/pay/<bill_id>/<transaction_id>')
def pay_my_bill(bill_id, transaction_id):
    from .models.store import pay_bill
    return pay_bill(bill_id, transaction_id)


if __name__ == "__main__":

    app.run()
