import time

def tick(secs):
    time.sleep(secs)
    print("tick")

def main():
    # ---------- Import Lightrun Agent ----------
    try:
        import lightrun
        lightrun.enable(agent_config="agent.config")
    except ImportError as e:
        print("Error importing Lightrun: ", e)
    # -------------------------------------------

    print("Start sleeping in loop")
    for i in range(2, 10000):
        tick(5)

if __name__ == '__main__':
    main()
