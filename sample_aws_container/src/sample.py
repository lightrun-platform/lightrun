def import_lightrun():
    try:
        import lightrun
        lightrun.enable(com_lightrun_server='https://app.lightrun.com/company/success', company_key='b33aaabc-2ef0-4bcd-9c09-e3de48ac90fe')
    except ImportError as e:
        print("Error importing Lightrun: ", e)

def start_fibonacci(n):
    if n in {0, 1}:
        return n
    return start_fibonacci(n - 1) + start_fibonacci(n - 2)

def main(event, context):
    import_lightrun()
    num = event['num']

    print("Calculating Fibonacci of {}...".format(num))
    start_fibonacci(num)