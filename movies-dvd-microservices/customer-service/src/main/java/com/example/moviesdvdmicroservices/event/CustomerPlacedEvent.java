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
public class CustomerPlacedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4383901058670065267L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerPlacedEvent\",\"namespace\":\"com.example.moviesdvdmicroservices.event\",\"fields\":[{\"name\":\"firstname\",\"type\":\"string\"},{\"name\":\"lastname\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"password\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CustomerPlacedEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CustomerPlacedEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CustomerPlacedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CustomerPlacedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CustomerPlacedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CustomerPlacedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CustomerPlacedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CustomerPlacedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CustomerPlacedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence firstname;
  private java.lang.CharSequence lastname;
  private java.lang.CharSequence email;
  private java.lang.CharSequence username;
  private java.lang.CharSequence password;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CustomerPlacedEvent() {}

  /**
   * All-args constructor.
   * @param firstname The new value for firstname
   * @param lastname The new value for lastname
   * @param email The new value for email
   * @param username The new value for username
   * @param password The new value for password
   */
  public CustomerPlacedEvent(java.lang.CharSequence firstname, java.lang.CharSequence lastname, java.lang.CharSequence email, java.lang.CharSequence username, java.lang.CharSequence password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return firstname;
    case 1: return lastname;
    case 2: return email;
    case 3: return username;
    case 4: return password;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: firstname = (java.lang.CharSequence)value$; break;
    case 1: lastname = (java.lang.CharSequence)value$; break;
    case 2: email = (java.lang.CharSequence)value$; break;
    case 3: username = (java.lang.CharSequence)value$; break;
    case 4: password = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
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
   * Gets the value of the 'username' field.
   * @return The value of the 'username' field.
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }


  /**
   * Sets the value of the 'username' field.
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'password' field.
   * @return The value of the 'password' field.
   */
  public java.lang.CharSequence getPassword() {
    return password;
  }


  /**
   * Sets the value of the 'password' field.
   * @param value the value to set.
   */
  public void setPassword(java.lang.CharSequence value) {
    this.password = value;
  }

  /**
   * Creates a new CustomerPlacedEvent RecordBuilder.
   * @return A new CustomerPlacedEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder newBuilder() {
    return new com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder();
  }

  /**
   * Creates a new CustomerPlacedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerPlacedEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder newBuilder(com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder other) {
    if (other == null) {
      return new com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder();
    } else {
      return new com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder(other);
    }
  }

  /**
   * Creates a new CustomerPlacedEvent RecordBuilder by copying an existing CustomerPlacedEvent instance.
   * @param other The existing instance to copy.
   * @return A new CustomerPlacedEvent RecordBuilder
   */
  public static com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder newBuilder(com.example.moviesdvdmicroservices.event.CustomerPlacedEvent other) {
    if (other == null) {
      return new com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder();
    } else {
      return new com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for CustomerPlacedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerPlacedEvent>
    implements org.apache.avro.data.RecordBuilder<CustomerPlacedEvent> {

    private java.lang.CharSequence firstname;
    private java.lang.CharSequence lastname;
    private java.lang.CharSequence email;
    private java.lang.CharSequence username;
    private java.lang.CharSequence password;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.firstname)) {
        this.firstname = data().deepCopy(fields()[0].schema(), other.firstname);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.lastname)) {
        this.lastname = data().deepCopy(fields()[1].schema(), other.lastname);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.username)) {
        this.username = data().deepCopy(fields()[3].schema(), other.username);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.password)) {
        this.password = data().deepCopy(fields()[4].schema(), other.password);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing CustomerPlacedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.moviesdvdmicroservices.event.CustomerPlacedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.firstname)) {
        this.firstname = data().deepCopy(fields()[0].schema(), other.firstname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lastname)) {
        this.lastname = data().deepCopy(fields()[1].schema(), other.lastname);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.username)) {
        this.username = data().deepCopy(fields()[3].schema(), other.username);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.password)) {
        this.password = data().deepCopy(fields()[4].schema(), other.password);
        fieldSetFlags()[4] = true;
      }
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
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder setFirstname(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.firstname = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'firstname' field has been set.
      * @return True if the 'firstname' field has been set, false otherwise.
      */
    public boolean hasFirstname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'firstname' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder clearFirstname() {
      firstname = null;
      fieldSetFlags()[0] = false;
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
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder setLastname(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.lastname = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lastname' field has been set.
      * @return True if the 'lastname' field has been set, false otherwise.
      */
    public boolean hasLastname() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lastname' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder clearLastname() {
      lastname = null;
      fieldSetFlags()[1] = false;
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
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.email = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder clearEmail() {
      email = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'username' field.
      * @return The value.
      */
    public java.lang.CharSequence getUsername() {
      return username;
    }


    /**
      * Sets the value of the 'username' field.
      * @param value The value of 'username'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.username = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'username' field has been set.
      * @return True if the 'username' field has been set, false otherwise.
      */
    public boolean hasUsername() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'username' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder clearUsername() {
      username = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'password' field.
      * @return The value.
      */
    public java.lang.CharSequence getPassword() {
      return password;
    }


    /**
      * Sets the value of the 'password' field.
      * @param value The value of 'password'.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder setPassword(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.password = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'password' field has been set.
      * @return True if the 'password' field has been set, false otherwise.
      */
    public boolean hasPassword() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'password' field.
      * @return This builder.
      */
    public com.example.moviesdvdmicroservices.event.CustomerPlacedEvent.Builder clearPassword() {
      password = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CustomerPlacedEvent build() {
      try {
        CustomerPlacedEvent record = new CustomerPlacedEvent();
        record.firstname = fieldSetFlags()[0] ? this.firstname : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.lastname = fieldSetFlags()[1] ? this.lastname : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.email = fieldSetFlags()[2] ? this.email : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.username = fieldSetFlags()[3] ? this.username : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.password = fieldSetFlags()[4] ? this.password : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CustomerPlacedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<CustomerPlacedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CustomerPlacedEvent>
    READER$ = (org.apache.avro.io.DatumReader<CustomerPlacedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.firstname);

    out.writeString(this.lastname);

    out.writeString(this.email);

    out.writeString(this.username);

    out.writeString(this.password);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);

      this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

      this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);

      this.password = in.readString(this.password instanceof Utf8 ? (Utf8)this.password : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.firstname = in.readString(this.firstname instanceof Utf8 ? (Utf8)this.firstname : null);
          break;

        case 1:
          this.lastname = in.readString(this.lastname instanceof Utf8 ? (Utf8)this.lastname : null);
          break;

        case 2:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        case 3:
          this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);
          break;

        case 4:
          this.password = in.readString(this.password instanceof Utf8 ? (Utf8)this.password : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










