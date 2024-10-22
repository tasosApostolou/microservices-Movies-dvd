/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.moviesdvdmicroservices.event;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class RentalPlaceEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4556166188293852970L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RentalPlaceEvent\",\"namespace\":\"com.example.moviesdvdmicroservices.event\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"movieId\",\"type\":\"string\"},{\"name\":\"firstname\",\"type\":\"string\"},{\"name\":\"lastname\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"days\",\"type\":\"string\"},{\"name\":\"price\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RentalPlaceEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RentalPlaceEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<RentalPlaceEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<RentalPlaceEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<RentalPlaceEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this RentalPlaceEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a RentalPlaceEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a RentalPlaceEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static RentalPlaceEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence movieId;
  private java.lang.CharSequence firstname;
  private java.lang.CharSequence lastname;
  private java.lang.CharSequence email;
  private java.lang.CharSequence status;
  private java.lang.CharSequence days;
  private java.lang.CharSequence price;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RentalPlaceEvent() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param movieId The new value for movieId
   * @param firstname The new value for firstname
   * @param lastname The new value for lastname
   * @param email The new value for email
   * @param status The new value for status
   * @param days The new value for days
   * @param price The new value for price
   */
  public RentalPlaceEvent(java.lang.CharSequence id, java.lang.CharSequence movieId, java.lang.CharSequence firstname, java.lang.CharSequence lastname, java.lang.CharSequence email, java.lang.CharSequence status, java.lang.CharSequence days, java.lang.CharSequence price) {
    this.id = id;
    this.movieId = movieId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.status = status;
    this.days = days;
    this.price = price;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return movieId;
    case 2: return firstname;
    case 3: return lastname;
    case 4: return email;
    case 5: return status;
    case 6: return days;
    case 7: return price;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: movieId = (java.lang.CharSequence)value$; break;
    case 2: firstname = (java.lang.CharSequence)value$; break;
    case 3: lastname = (java.lang.CharSequence)value$; break;
    case 4: email = (java.lang.CharSequence)value$; break;
    case 5: status = (java.lang.CharSequence)value$; break;
    case 6: days = (java.lang.CharSequence)value$; break;
    case 7: price = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'movieId' field.
   * @return The value of the 'movieId' field.
   */
  public java.lang.CharSequence getMovieId() {
    return movieId;
  }


  /**
   * Sets the value of the 'movieId' field.
   * @param value the value to set.
   */
  public void setMovieId(java.lang.CharSequence value) {
    this.movieId = value;
  }

  /**
   * Gets the value of the 'firstname' field.
   * @return The value of the 'firstname' field.
   */
  public java.lang.CharSequence getFirstname() {
    return firstname;
  }


  /**
   * Sets the value of the 'firstname' field.
   * @param value the value to set.
   */
  public void setFirstname(java.lang.CharSequence value) {
    this.firstname = value;
  }

  /**
   * Gets the value of the 'lastname' field.
   * @return The value of the 'lastname' field.
   */
  public java.lang.CharSequence getLastname() {
    return lastname;
  }


  /**
   * Sets the value of the 'lastname' field.
   * @param value the value to set.
   */
  public void setLastname(java.lang.CharSequence value) {
    this.lastname = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.CharSequence getStatus() {
    return status;
  }


  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.CharSequence value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'days' field.
   * @return The value of the 'days' field.
   */
  public java.lang.CharSequence getDays() {
    return days;
  }


  /**
   * Sets the value of the 'days' field.
   * @param value the value to set.
   */
  public void setDays(java.lang.CharSequence value) {
    this.days = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.CharSequence getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.CharSequence value) {
    this.price = value;
  }

  /**
   * Creates a new RentalPlaceEvent RecordBuilder.
   * @return A new RentalPlaceEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder newBuilder() {
    return new com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder();
  }

  /**
   * Creates a new RentalPlaceEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RentalPlaceEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder newBuilder(com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder other) {
    if (other == null) {
      return new com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder();
    } else {
      return new com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder(other);
    }
  }

  /**
   * Creates a new RentalPlaceEvent RecordBuilder by copying an existing RentalPlaceEvent instance.
   * @param other The existing instance to copy.
   * @return A new RentalPlaceEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder newBuilder(com.example.moviesdvdmicroservices.event.RentalPlaceEvent other) {
    if (other == null) {
      return new com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder();
    } else {
      return new com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for RentalPlaceEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RentalPlaceEvent>
    implements org.apache.avro.data.RecordBuilder<RentalPlaceEvent> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence movieId;
    private java.lang.CharSequence firstname;
    private java.lang.CharSequence lastname;
    private java.lang.CharSequence email;
    private java.lang.CharSequence status;
    private java.lang.CharSequence days;
    private java.lang.CharSequence price;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.movieId)) {
        this.movieId = data().deepCopy(fields()[1].schema(), other.movieId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.firstname)) {
        this.firstname = data().deepCopy(fields()[2].schema(), other.firstname);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.lastname)) {
        this.lastname = data().deepCopy(fields()[3].schema(), other.lastname);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.email)) {
        this.email = data().deepCopy(fields()[4].schema(), other.email);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.days)) {
        this.days = data().deepCopy(fields()[6].schema(), other.days);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.price)) {
        this.price = data().deepCopy(fields()[7].schema(), other.price);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing RentalPlaceEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.moviesdvdmicroservices.event.RentalPlaceEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.movieId)) {
        this.movieId = data().deepCopy(fields()[1].schema(), other.movieId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.firstname)) {
        this.firstname = data().deepCopy(fields()[2].schema(), other.firstname);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.lastname)) {
        this.lastname = data().deepCopy(fields()[3].schema(), other.lastname);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.email)) {
        this.email = data().deepCopy(fields()[4].schema(), other.email);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.days)) {
        this.days = data().deepCopy(fields()[6].schema(), other.days);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.price)) {
        this.price = data().deepCopy(fields()[7].schema(), other.price);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'movieId' field.
      * @return The value.
      */
    public java.lang.CharSequence getMovieId() {
      return movieId;
    }


    /**
      * Sets the value of the 'movieId' field.
      * @param value The value of 'movieId'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setMovieId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.movieId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'movieId' field has been set.
      * @return True if the 'movieId' field has been set, false otherwise.
      */
    public boolean hasMovieId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'movieId' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearMovieId() {
      movieId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstname' field.
      * @return The value.
      */
    public java.lang.CharSequence getFirstname() {
      return firstname;
    }


    /**
      * Sets the value of the 'firstname' field.
      * @param value The value of 'firstname'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setFirstname(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.firstname = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'firstname' field has been set.
      * @return True if the 'firstname' field has been set, false otherwise.
      */
    public boolean hasFirstname() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'firstname' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearFirstname() {
      firstname = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastname' field.
      * @return The value.
      */
    public java.lang.CharSequence getLastname() {
      return lastname;
    }


    /**
      * Sets the value of the 'lastname' field.
      * @param value The value of 'lastname'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setLastname(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.lastname = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'lastname' field has been set.
      * @return True if the 'lastname' field has been set, false otherwise.
      */
    public boolean hasLastname() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'lastname' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearLastname() {
      lastname = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.email = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearEmail() {
      email = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.CharSequence getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setStatus(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.status = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearStatus() {
      status = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'days' field.
      * @return The value.
      */
    public java.lang.CharSequence getDays() {
      return days;
    }


    /**
      * Sets the value of the 'days' field.
      * @param value The value of 'days'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setDays(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.days = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'days' field has been set.
      * @return True if the 'days' field has been set, false otherwise.
      */
    public boolean hasDays() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'days' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearDays() {
      days = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.CharSequence getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder setPrice(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.price = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.RentalPlaceEvent.Builder clearPrice() {
      price = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RentalPlaceEvent build() {
      try {
        RentalPlaceEvent record = new RentalPlaceEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.movieId = fieldSetFlags()[1] ? this.movieId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.firstname = fieldSetFlags()[2] ? this.firstname : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.lastname = fieldSetFlags()[3] ? this.lastname : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.email = fieldSetFlags()[4] ? this.email : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.status = fieldSetFlags()[5] ? this.status : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.days = fieldSetFlags()[6] ? this.days : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.price = fieldSetFlags()[7] ? this.price : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RentalPlaceEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<RentalPlaceEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RentalPlaceEvent>
    READER$ = (org.apache.avro.io.DatumReader<RentalPlaceEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.movieId);

    out.writeString(this.firstname);

    out.writeString(this.lastname);

    out.writeString(this.email);

    out.writeString(this.status);

    out.writeString(this.days);

    out.writeString(this.price);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.movieId = in.readString(this.movieId instanceof Utf8 ? (Utf8)this.movieId : null);

      this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);

      this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

      this.status = in.readString(this.status instanceof Utf8 ? (Utf8)this.status : null);

      this.days = in.readString(this.days instanceof Utf8 ? (Utf8)this.days : null);

      this.price = in.readString(this.price instanceof Utf8 ? (Utf8)this.price : null);

    } else {
      for (int i = 0; i < 8; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.movieId = in.readString(this.movieId instanceof Utf8 ? (Utf8)this.movieId : null);
          break;

        case 2:
          this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);
          break;

        case 3:
          this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);
          break;

        case 4:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        case 5:
          this.status = in.readString(this.status instanceof Utf8 ? (Utf8)this.status : null);
          break;

        case 6:
          this.days = in.readString(this.days instanceof Utf8 ? (Utf8)this.days : null);
          break;

        case 7:
          this.price = in.readString(this.price instanceof Utf8 ? (Utf8)this.price : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










