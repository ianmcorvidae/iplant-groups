(ns iplant-groups.core-test
  (:use [clojure.test]
        [iplant-groups.core])
  (:require [iplant-groups.util.config :as config]))

(deftest test-default-config
  (require 'iplant-groups.util.config :reload)
  (config/load-config-from-file "conf/test/empty.properties")
  (testing "default configuration settings"
    (is (= (config/listen-port) 60000))
    (is (= (config/grouper-base) "http://grouper:60000/grouper-ws/"))
    (is (= (config/grouper-api-version) "v2_2_000"))
    (is (= (config/grouper-username) "GrouperSystem"))
    (is (= (config/grouper-password) "notprod"))))
