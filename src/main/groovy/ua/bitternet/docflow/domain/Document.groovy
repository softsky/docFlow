package ua.bitternet.docflow.domain
import grails.persistence.Entity;

/**
 * Simple domain object representing an abstract document.
 *
 * @author Arsen A. Gutsal (gutsal.arsen@gmail.com)
 */
@Entity

class Document {
  String type

  boolean isNew() { id == null }

  static hasMany = [rows:Row]

  static transients = ['new']

  static constraints = {
    type blank:false
  }

  static mapping = {
    rows fetch:'join'
  }

}