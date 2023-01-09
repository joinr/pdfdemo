(ns pdfdemo.core
  (:require [clojure.java.io :as io])
  (:import [org.apache.pdfbox.pdmodel PDPage PDDocument]))

;;create a new document, add a blank page, save it.
;;per https://pdfbox.apache.org/1.8/cookbook/documentcreation.html
(doto (PDDocument.)
      (.addPage (PDPage.))
      (.save "BlankPage.pdf")
      (.close))

;;from https://www.tutorialspoint.com/pdfbox/pdfbox_loading_a_document.htm, with
;;minor modifications.
(def file (io/file "BlankPage.pdf"))
(def document (PDDocument/load file)) ;;invoke static method.
(println "PDF Loaded")
;;use .method for method/member, use constructor. for constructor, also couldd use (new PDPage)
(.addPage document (PDPage.))
;;save document
(.save document "BlankPages.pdf")
(.close document)

;;similarly...
(comment
  (doto (PDDocument/load file)
    (.addPage (PDPage.))
    (.save)
    (.close))
  )
