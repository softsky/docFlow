package ua.bitternet.docflow.domain

import grails.persistence.Entity;

/**
 * Simple domain object representing a pet.
 *
 * @author Arsen A. Gutsal (gutsal.arsen@gmail.com)
 */

@Entity
class Row {

  String name
  Date date
  Document document

  boolean isNew() { id == null }

  static transients = ['new']

  static constraints = {
    name blank:false, validator: { val, obj ->
      if(!obj.id &&  obj.owner?.pets?.find { it.name == val && !it.is(obj) }) return "pet.duplicate"
    }
  }


}


