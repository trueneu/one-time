(ns one-time.codec
  ;(:import org.apache.commons.codec.binary.Base32)
  (:require [base32-clj.core :as base32]))

(comment
  (encode-binary (.getBytes "abcd"))
  (String. (decode-binary (encode-binary (.getBytes "abcd"))))

  (decode (encode "abcd"))

  (encode "abcd")

  (encode-binary2 (.getBytes "abcd"))
  (encode2 "abcd")
  (String. (decode-binary2 (encode-binary2 (.getBytes "abcd"))))
  (decode2 (encode2 "abcd")))

(defn encode-binary
  "Encodes a binary to base32 string."
  [data]
  (String. (base32/encode-bytes data)))

(defn encode
  "Encodes a string to base32 string."
  [^String string]
  (base32/encode string))

(defn decode-binary
  "Decodes a base32 string to binary."
  ^bytes [string]
  (base32/decode-bytes (.getBytes string)))

(defn decode
  "Decodes a base32 string to string."
  [string]
  (base32/decode string))

(comment
  (defn encode-binary2
    "Encodes a binary to base32 string."
    [data]
    (.encodeAsString (Base32.) data))

  (defn encode2
    "Encodes a string to base32 string."
    [^String string]
    (encode-binary2 (.getBytes string)))

  (defn decode-binary2
    "Decodes a base32 string to binary."
    ^bytes [string]
    (.decode (Base32.) string))

  (defn decode2
    "Decodes a base32 string to string."
    [string]
    (String. (decode-binary2 string))))
