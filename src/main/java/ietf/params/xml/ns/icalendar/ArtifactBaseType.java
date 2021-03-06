/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * The artifact Base is here for use in extending by other specifications, to to
 * allow attributes from other namespaces to be added to ws-calendar-based
 * schemas.
 * <p>
 * Java class for ArtifactBaseType complex type. The following schema fragment
 * specifies the expected content contained within this class.
 * <pre> &lt;complexType name="ArtifactBaseType"&gt; &lt;complexContent&gt;
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 * &lt;/restriction&gt; &lt;/complexContent&gt; &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArtifactBaseType")
public abstract class ArtifactBaseType {
}
