<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:element="http://localhost/p-laba1" version="2.0">
   <!-- Пункт №4 - указываем метода вывода - HTML -->
   <xsl:output method="html" encoding="UTF-8" version="5.2" indent="yes" />
   <xsl:template match="/">
      <html>
         <!--Пункт №1 - вызываем именованный шаблон -->
         <xsl:call-template name="head" />
         <body>
            <table>
               <thead>
                  <tr>
                     <td>ID</td>
                     <td>carAdvName</td>
                     <td>carAdvDate</td>
                     <td>Статус</td>
                     <td>inn</td>
                     <td>passport</td>
                     <td>Доступность</td>
                  </tr>
               </thead>
               <tbody>
                  <!--Пункт №2 - использование цикла - for -->
                  <xsl:for-each select="element:exclusiveCarAdvList/element:exclusiveCarAdv">
                     <!--Пункт №3 - использование сортировки по убыванию и по полю status -->
                     <xsl:sort select="element:id" order="descending"/>
                     <tr>
                        <!--Пункт №3 - использование нумерации с помощью функции position() -->
                        <td><xsl:number value="position()" format="1"/></td>
                        <td><xsl:value-of select="element:id"/></td>
                        <td><xsl:value-of select="element:carAdvName"/></td>
                        <td><xsl:value-of select="element:carAdvStatus"/></td>
                        <td><xsl:value-of select="element:carAdvDate"/></td>
                        <td>
                           <xsl:value-of select="element:ownersDocumentsList">
                              <xsl:value-of select="element:inn"/>
                              <xsl:value-of select="element:passport"/>
                           </xsl:value-of>
                        </td>
                        <th>
                           <!--Пункт №2 - использование ветвления - choose -->
                           <xsl:choose>
                              <xsl:when test="element:carAdvStatus = 'ACTIVE'">
                                 Активно
                              </xsl:when>
                              <xsl:otherwise>
                                 Не активно
                              </xsl:otherwise>
                           </xsl:choose>
                        </th>
                     </tr>
                  </xsl:for-each>
               </tbody>
               <tfoot>
                  <tr>
                     <td>Итого:</td>
                     <td><xsl:value-of select="count(element:exclusiveCarAdvList/element:exclusiveCarAdv)"/></td>
                  </tr>
               </tfoot>
            </table>
         </body>
      </html>
   </xsl:template>

   <!--Пункт №1 - объявляем именованный шаблон -->
   <xsl:template name="head">
      <head>
         <link rel="stylesheet" href="main.css"/>
      </head>
   </xsl:template>
</xsl:stylesheet>
