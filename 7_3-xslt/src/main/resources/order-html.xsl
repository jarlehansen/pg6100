<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Sold Items</h2>
                <table cellpadding="6">
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                    </tr>

                    <xsl:for-each select="order/content/order_line">
                        <tr>
                            <td>
                                <xsl:value-of select="@item"/>
                            </td>
                            <td>
                                <xsl:value-of select="@quantity"/>
                            </td>
                            <td>
                                <xsl:value-of select="unit_price"/>
                            </td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>