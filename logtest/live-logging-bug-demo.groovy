/**
 *  Live Logging Bug Demo
 *
 *  Copyright 2016 Eric Mayers
 *
 *  This "device" demonstrates bad behavior in the smartthings live logging system.  Specifically,
 *  a percentage of logging entries are not delivered to the live logging console.  This attempts
 *  to facilitate testing this behavior by simply firing a series of log.debug statements and those
 *  log lines are arranged such that it's easy to see where they are missing or out of order.
 *
 *  Example output below the code.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "Live Logging Bug Demo", namespace: "erisod", author: "Eric Mayers") {
        capability "Polling"
	}

	tiles {
		standardTile("logtest", "Run Log Tester", inactiveLabel: false, decoration: "flat") {
            state "default", action:"polling.poll", label:"Run Test", icon:"http://34.gs/e1jr"
        }

        main "logtest"
        details(["logtest"])
	}
}

def poll() {
  log_tester()
}

def log_tester() {
    log.debug "-- log_tester() Starting -- "
    
    (0..100).each {
      log.debug "${'-' * it} ${it}"
    }
    
    log.debug "-- log_tester() Complete -- "
}


/** Example Output from a run on Sat Jan 2 2016 at 12:52pm Pacific.
 *  It is worth noting that sometimes the "Starting" / "Complete" lines also don't show up, but I've
 *  cherry picked an example where they are present.  This is copy/pasted from the live logging console
 *  (https://graph.api.smartthings.com/ide/logs), so it is in reverse temporal order.
 
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -- log_tester() Complete --
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------------------------------------------------------------------------------- 100
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------------------------------------------------------------------------------------------- 99
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -------------------------------------------------------------------------------------------------- 98
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------------------------------------------- 97
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------------------------------------------ 96
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------------------------------------------------------------------------------------- 95
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------------------------------------------------------------------------- 94
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------------------------------------------------------------- 71
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------------------------------------------------------------- 69
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------------------------------------------------- 70
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------------- 67
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------------ 66
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -------------------------------------------------------------------- 68
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------------------------------------------------------- 63
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -------------------------------------------------------------- 62
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------ 60
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------------------------------- 61
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------------------------------------------------- 59
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------------------------------------- 58
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------------------------------------------- 53
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------- 37
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------------------------- 35
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------------------------ 36
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------------- 34
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------------------------- 33
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------------- 28
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------------------- 27
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------------- 22
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -------------------- 20
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------------ 18
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------------- 16
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------------- 17
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------------- 15
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------------- 13
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----------- 11
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---------- 10
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --------- 9
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -------- 8
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------ 6
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ------- 7
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ----- 5
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug ---- 4
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug --- 3
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -- 2
9a54187b-7b99-4fcf-a193-0df98bc45a57  12:52:53 PM: debug -- log_tester() Starting -- 

 */
