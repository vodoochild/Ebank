from .model import Bill, Client, engine
import json
from sqlalchemy.orm import sessionmaker
from sqlalchemy.orm import Session


def get_all_bills():
    bills = Bill.query.all()
    return bills

def get_client(number_in):
    db_number = number_in[1:]
    client = Client.query.filter_by(number=db_number).first()
    return client


def get_my_bills(number):
    my_bills = []
    bills = get_all_bills()
    client = get_client(number)
    if client is None :
        return client, my_bills
    for bill in bills:
        if bill.client.id == client.id and bill.paid is False:
            my_bills.append(bill)
    return client, my_bills


def bills_toJson(number):
    client, my_bills = get_my_bills(number)
    if client is None:
        out_json = {"message": "Number is not correct"}
        return json.dumps(out_json)
    out_json = {"numberofbills": len(my_bills), "client":{"name": client.firstName+" "+client.lastName,
                                                            "number": client.number}, "bills": []}
    if len(my_bills) == 0:
        pass
    else:
        for bill in my_bills:
            out_json["bills"].append({"bill_Id": bill.id, "date": bill.date,"bill_Value": bill.value})

    return json.dumps(out_json)


def pay_bill(bill_id, transaction_id):
    # appel au web service de la banque pour demander est ce que vraiment la transaction a réalisé
    test = transaction_id # on va appeler le web service du banque
    if not transaction_id:
        out_json = {"message": "On a pas recu le paiement"}
        return json.dumps(out_json)

    Session = sessionmaker(bind=engine)
    session = Session()

    bill = session.query(Bill).get(bill_id)
    if bill is None:
        print("Bill don't exist")
        session.close()
        out_json = {"message": "il n'y a aucune facture avec cette id"}
        return json.dumps(out_json)
    else:
        if bill.paid ==True :
            print("Bill already paid")
            session.close()
            out_json = {"message": "Facture déja payée"}
            return json.dumps(out_json)
        bill.paid = True
        session.commit()
        print("Bill paid")
        session.close()
        out_json = {"message": "Facture payée"}
        return json.dumps(out_json)


def all_bills_toJson(number):
    client = get_client(number)
    if client is None:
        out_json = {"message": "Number is not correct"}
        return json.dumps(out_json)
    bills = get_all_bills()
    my_bills = []
    for bill in bills:
        if bill.client.id == client.id:
            my_bills.append(bill)
    out_json = {"numberofbills": len(my_bills), "client": {"name": client.firstName + " " + client.lastName,
                                                             "number": client.number}, "bills": []}
    if len(my_bills) == 0:
        pass
    else:
        for bill in my_bills:
            out_json["bills"].append({"bill_Id": bill.id, "date": bill.date, "bill_Value": bill.value, "paid": bill.paid})
    return json.dumps(out_json)



def test(text):
    out_json = {"NumberOfBills": 0, "Client": "Ayoub el Ouarak"}
    return json.dumps(out_json)